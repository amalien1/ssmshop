package com.zzw.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.zzw.pojo.Order;
import com.zzw.pojo.Product;
import com.zzw.pojo.ProductType;
import com.zzw.pojo.QueryVo;
import com.zzw.service.ManagerService;
import com.zzw.service.OrderService;
import com.zzw.service.ProductService;
import com.zzw.service.ProductTypeService;
/**
 * 管理员控制器
 * @author amalien
 *
 */
@Controller
public class ManagerController {
	@Autowired //商品类型service注入
	private ProductTypeService productTypeService;
	@Autowired //商品service注入
	private ProductService productService;
	@Autowired //订单service注入
	private OrderService orderService;
	//显示管理员界面
	@RequestMapping(value="/managerIndex")
	public String showManagerIndex() {
		return "managerIndex";
	}
	//显示管理员商品管理页面
	@RequestMapping(value="/productManage")
	public String showProductManager(Model model,QueryVo vo) {
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
		return "productManage";
	}
	//显示添加商品页面
	@RequestMapping(value="/addProduct")
	public String addProduct(Model model){
		List<ProductType> productTypeList = productTypeService.selectAll();
		model.addAttribute("productType", productTypeList);
		return "addProduct";
	}
	//添加商品
	@RequestMapping(value="doAddProduct",method=RequestMethod.POST)
	public String doAddProduct(Product product,MultipartFile pimg,HttpServletRequest request) throws Exception{
		//System.out.println(product);
		//图片上传
		// 设置图片名称，使用uuid
		String picName = UUID.randomUUID().toString();
		// 获取文件名
		String oriName = pimg.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));
		// 开始上传
		pimg.transferTo(new File(request.getServletContext().getRealPath("/imgs")+"/"+picName + extName));
		// 设置图片名到商品中
		product.setPimage(picName + extName);
		productService.insertProduct(product);
		return "redirect:productManage";
	}
	
	//删除商品
	@RequestMapping(value="deleteProduct")
	public String deleteProduct(Integer id){
		productService.deleteProductById(id);
		return "redirect:productManage";
	}
	//显示修改商品信息页面
	@RequestMapping(value="/editProduct")
	public String showEditProduct(Model model,Integer id){
		List<ProductType> productTypeList = productTypeService.selectAll();
		model.addAttribute("productType", productTypeList);
		Product product = productService.selectProductById(id);
		System.out.println(product);
		model.addAttribute("product", product);
		return "editProduct";
	}
	//修改商品信息
	@RequestMapping(value="doEditProduct")
	public String editProduct(Product product,MultipartFile pimg,HttpServletRequest request) throws Exception {
		//System.out.println(pimg);
		//System.out.println(product);
		if(pimg.getSize()>0){
			String picName = UUID.randomUUID().toString();
			String oriName = pimg.getOriginalFilename();
			String extName = oriName.substring(oriName.lastIndexOf("."));
			pimg.transferTo(new File(request.getServletContext().getRealPath("/imgs")+"/"+picName + extName));
			product.setPimage(picName + extName);
		}
		//System.out.println(product);
		productService.updateProduct(product);
		return "redirect:productManage"; 
	}
	//显示订单管理界面
	@RequestMapping(value="/orderManage")
	public String showOrderManage(Model model){
		List<Order> orderList = orderService.selectAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Order order : orderList) {
			order.setStringTime(sdf.format(order.getOrdertime()));
		}
		model.addAttribute("orderList", orderList);
		return "orderManage";
	}
	//订单删除
	@RequestMapping(value="deleteOrder")
	public String deleteOrder(Integer oid){
		orderService.deleteOrder(oid);
		return "redirect:orderManage";
	}
	//订单状态改变
	@RequestMapping(value="changeOrderState")
	public String changeOrderState(Integer oid,Integer state){
		orderService.changeOrderState(oid, state);
		return "redirect:orderManage";
	}
	//显示商品类别管理
	@RequestMapping(value="/productTypeManage")
	public String showProductTypeManage(Model model){
		List<ProductType> productTypeList = productTypeService.selectAll();
		model.addAttribute("productType", productTypeList);
		return "productTypeManage";
	}
	//显示修改商品类别界面
	@RequestMapping(value="editProductType")
	public String showEditProductType(Model model,Integer id){
		ProductType productType=productTypeService.selectProductTypeById(id);
		model.addAttribute("productType", productType);
		return "editProductType";
	}
	//修改商品类别
	@RequestMapping(value="doEditProductType")
	public String editProductType(ProductType productType,Model model,String oldName){
		
		if(!oldName.equals(productType.getTypename())){
			if(productTypeService.updateProductType(productType)){
				return "redirect:productTypeManage";
			}else{
				model.addAttribute("editmsg", "类型名重复请重新输入！");
				return "forward:editProductType?id="+productType.getId();
			}
		}
		return "redirect:productTypeManage";
	}
	//添加商品类别
	@RequestMapping(value="doAddProductType")
	public String addProductType(ProductType productType,Model model){
		if(!productTypeService.addProductType(productType)){
			model.addAttribute("addmsg", "商品类型重复！！请重新添加");
		}
		return "forward:productTypeManage";
		
	}
	//删除商品类别
	@RequestMapping(value="deleteProductType")
	public String deleteProductType(Integer id){
		productTypeService.deleteProductTypeById(id);
		return "redirect:productTypeManage";
	}
}
