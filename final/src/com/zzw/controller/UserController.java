package com.zzw.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zzw.pojo.Cart;
import com.zzw.pojo.CartItem;
import com.zzw.pojo.Manager;
import com.zzw.pojo.Order;
import com.zzw.pojo.OrderItem;
import com.zzw.pojo.Product;
import com.zzw.pojo.ProductType;
import com.zzw.pojo.QueryVo;
import com.zzw.pojo.User;
import com.zzw.service.CartService;
import com.zzw.service.ManagerService;
import com.zzw.service.OrderService;
import com.zzw.service.ProductService;
import com.zzw.service.ProductTypeService;
import com.zzw.service.UserService;
import com.zzw.util.CookieUtil;

/**
 * 用户控制器
 * @author amalien
 *
 */
@Controller
public class UserController {
	@Autowired //用户service注入
	private UserService userService;
	@Autowired //管理员service注入
	private ManagerService managerService;
	@Autowired  //商品类别service注入
	private ProductTypeService productTypeService;
	@Autowired  //商品service注入
	private ProductService productService;
	@Autowired //购物车service注入
	private CartService cartService;
	@Autowired //订单service注入
	private OrderService orderService;
	//显示主界面
	@RequestMapping(value="/index")
	public String showIndex(Model model,QueryVo vo) {
		List<ProductType> productTypeList = productTypeService.selectAll();
		model.addAttribute("productType", productTypeList);
		vo.setStartRow(vo.getSize()*(vo.getPage()-1));
		List<Product> list = productService.selectProductByQueryVo(vo);
		model.addAttribute("productList",list);
		int count=productService.count(vo);
		vo.setCount(count);
		int totalPage=count/vo.getSize();
		if(count%vo.getSize()>0||totalPage==0){
			totalPage++;
		}
		vo.setTotalPage(totalPage);
		model.addAttribute("QueryVo", vo);
		return "index";
	}
	//显示用户登录界面
	@RequestMapping(value="/login")
	public String showLogin(HttpServletRequest request){
		String username=(String) request.getSession().getAttribute("username");
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.findCookie(cookies, "rem_user");
		if(null!=cookie){
			request.getSession().setAttribute("rem_user",cookie.getValue());
		}
		
		if(null!=username&&""!=username){
			return "index";
		}
		return "login";
	}
	//显示用户注册界面
	@RequestMapping(value="/register")
	public String showRegister() {
		return "register";
	}
	//异步判断用户名是否存在
	@RequestMapping(value="checkUser",method=RequestMethod.POST)
	public void checkUser(HttpServletResponse response,String name) throws Exception {
		System.out.println(name);
		if(!"".equals(name)&&null!=name){
			if(null!=userService.selectUserByUsername(name)){
				response.getWriter().println(1);
			}else{
				response.getWriter().println(2);
			}
		}

	}
	//用户登录
	@RequestMapping(value="doLogin",method=RequestMethod.POST)
	public String login(String remUser,String autoLogin,User user,Manager manager,Model model,
			HttpServletRequest request,HttpServletResponse response){
/*		System.out.println(user);
		System.out.println(manager);*/
		if("on".equals(remUser)){
			Cookie cookie=new Cookie("rem_user",user.getUsername());
			cookie.setMaxAge(60*60*24*5);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			request.getSession().setAttribute("rem_user",cookie.getValue());
		}else {
			Cookie cookie=new Cookie("rem_user",user.getUsername());
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			request.getSession().removeAttribute("rem_user");
		}
		if(null==managerService.login(manager)){
			User u=userService.login(user);
			if(u==null){
				model.addAttribute("msg", "用户名密码错误");
				return "login";
			}else{
				if("on".equals(autoLogin)){
					Cookie cookie=new Cookie("auto_login",user.getUsername()+"#"+user.getPassword());
					cookie.setMaxAge(60*60*24*5);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("username", u.getUsername());
				return "redirect:index";
			}

		}
		request.getSession().setAttribute("managername", manager.getUsername());
		return "redirect:managerIndex";
	}

	//用户注册
	@RequestMapping(value="doRegister",method=RequestMethod.POST)
	public String register(User user,Model model,HttpServletResponse response) throws Exception{
		//System.out.println(user);
		if(null!=user&&userService.register(user)){
			return "registerSuccess";
		}
		model.addAttribute("msg", "用户名已被使用！");
		return "register";
	}
	//用户注销
	@RequestMapping(value="logOut")
	public String logOut(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("username");
		if(request.getSession().getAttribute("managername")!=null||!"".equals(request.getSession().getAttribute("managername")))
			request.getSession().removeAttribute("managername");
		Cookie cookie=new Cookie("auto_login","111");
		cookie.setMaxAge(0);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		return "redirect:login";
	}
	//显示用户更改页面
	@RequestMapping(value="/editUser")
	public String showEdit(HttpServletRequest request){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.selectUserByUsername(username);
		request.getSession().setAttribute("user", user);
		return "editUser";
	}
	//用户信息更改
	@RequestMapping(value="doEditUser",method=RequestMethod.POST)
	public String editUser(User user,HttpServletRequest request){
		User oldUser = (User) request.getSession().getAttribute("user");
		user.setId(oldUser.getId());
		user.setUsername(oldUser.getUsername());
		user.setLevel(oldUser.getLevel());
		//System.out.println(user);
		userService.update(user);
		return "redirect:editUser";
	}
	
	//显示购物车
	@RequestMapping(value="/cart")
	public String shoppingCart(Model model,HttpServletRequest request){
		String username=(String) request.getSession().getAttribute("username");
		Cart cart=cartService.selectCartByUsername(username);
		model.addAttribute("cart", cart);
		return "shoppingCart";
	}
	//添加购物车商品
	@RequestMapping(value="addCartItem")
	public String addCartItem(Integer pid,HttpServletRequest request){
		String username = (String) request.getSession().getAttribute("username");
		cartService.addCartItem(username, pid);
		return "redirect:index";
	}
	//删除购物车商品
	@RequestMapping(value="deleteCartItem")
	public String deleteCartItem(HttpServletRequest request,Integer pid){
		String username = (String) request.getSession().getAttribute("username");
		cartService.deleteCartItem(username, pid);
		return "redirect:cart";
	}
	//清空购物车
	@RequestMapping(value="clearCart")
	public String clearCart(HttpServletRequest request){
		String username = (String)request.getSession().getAttribute("username");
		cartService.clearCart(username);
		return "redirect:cart";
	}
	//显示确认支付页面
	@RequestMapping(value="/pay")
	public String showPay(Model model,HttpServletRequest request,Integer pid){
		Cart cart=new Cart();
		System.out.println(pid);
		if(null==pid||pid==0){
			String username = (String)request.getSession().getAttribute("username");
			cart=cartService.selectCartByUsername(username);
			model.addAttribute("typeflag","0");
		}else{
			Product product = productService.selectProductById(pid);
			double price=Double.parseDouble(product.getPrice());
			CartItem cartItem=new CartItem(product.getId(),product.getPimage(), product.getPname(),price ,1);
			List<CartItem> list=new ArrayList<CartItem>();
			list.add(cartItem);
			cart.setList(list);
			cart.setTotalPrice(price);
			model.addAttribute("typeflag","1");
		}
		model.addAttribute("cart", cart);
		return "pay";
	}
	//显示订单界面
	@RequestMapping(value="/orderlist")
	public String showOrderList(Model model,HttpServletRequest request){
		String username = (String)request.getSession().getAttribute("username");
		List<Order> orderList = orderService.selectOrderByUsername(username);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Order order : orderList) {
			order.setStringTime(sdf.format(order.getOrdertime()));
		}
		model.addAttribute("orderList", orderList);
		return "orderList";
	}
	//添加订单
	@RequestMapping(value="addOrder")
	public String addOrder(String typeflag,OrderItem orderItem,Order order,HttpServletRequest request){
		String username = (String)request.getSession().getAttribute("username");
		orderService.addOrder(username,typeflag, order, orderItem);
		return "redirect:orderlist";
	}
	
	//确认收货
	@RequestMapping(value="confirmOrder")
	public String confirmOrder(Integer oid){
		orderService.updateOrderState(oid);
		return "redirect:orderlist";
	}
	
}
