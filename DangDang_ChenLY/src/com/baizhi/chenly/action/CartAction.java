package com.baizhi.chenly.action;

import java.util.HashMap;
import java.util.Set;

import com.baizhi.chenly.entity.Book;
import com.baizhi.chenly.entity.Cart;
import com.baizhi.chenly.entity.CartItem;
import com.baizhi.chenly.service.BookService;
import com.baizhi.chenly.service.BookServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class CartAction extends ActionSupport{
	private Integer bookId;
	//获取变更的图书数量
	private Integer bookCount;
	//private CartItem cartItem;//购物车项
	private BookService bs = new BookServiceImpl();
	//添加购物车
	public String addCartItem(){
		//从session中获取购物车
		ValueStack vs = ActionContext.getContext().getValueStack();
		Cart cart = (Cart)vs.findValue("#session.cart");
		Book book = bs.queryByBookId(bookId);
		//System.out.println(bookId);
		//HashMap<String,CartItem> cart = (HashMap<String, CartItem>) vs.findValue("#session.cart");
		if(cart==null){//说明是第一次访问
			//则新建一个购物车
			cart = new Cart();
			//新建一个购物车Map集合用于存储购物车项
			HashMap<String, CartItem> showCartMap = new HashMap<String,CartItem>();
			//获取图书信息
			//book = bs.queryByBookId(bookId);
			//新建购物车项
			CartItem cartItem = new CartItem(bookId,book.getBookName(),book.getBookPrice(),book.getBookDprice(),1);
			//将购物车项添加入map中
			showCartMap.put(bookId.toString(), cartItem);
			//计算总价和节省价格
			cart.setTotalPrice(book.getBookDprice());
			cart.setSavePrice(book.getBookPrice()-book.getBookDprice());
			
			cart.setShowCartMap(showCartMap);
			//将购物车重新放回session中
			
			/*Set<String> bookIds = showCartMap.keySet();
			for (String id : bookIds) {
				System.out.println(id+"~~~~~~~~~"+showCartMap.get(id));
			}*/
			//vs.setValue("#session.showCartMap", showCartMap);
			vs.setValue("#session.cart", cart);
		}else{//如果cart不为空
			//在cart不为空的情况下,将bookId作为Map的key值
			//判断获取的商品id购车车里是否有
			//System.out.println(cart);
			HashMap<String,CartItem> showCartMap= cart.getShowCartMap();
			if(showCartMap.containsKey(bookId.toString())){
				//如果包含有，则数量加1
				Integer count=showCartMap.get(bookId.toString()).getAmount()+1;
				showCartMap.get(bookId.toString()).setAmount(count);
			}else{
				//如果不包含，则说明购物车中没有此商品，则加入购物车
				//Book book = bs.queryByBookId(bookId);
				cart.getShowCartMap().put(bookId.toString(), new CartItem(bookId,book.getBookName(),book.getBookPrice(),book.getBookDprice(),1));
			}
			Set<String> bookIds = showCartMap.keySet();
			//总价和节省价
			Double newTotlePrice = 0.0;
			Double newAllPrice = 0.0;
			for (String id : bookIds) {
				newTotlePrice+=bs.queryByBookId(Integer.parseInt(id)).getBookDprice()*showCartMap.get(id).getAmount();
				newAllPrice += bs.queryByBookId(Integer.parseInt(id)).getBookPrice()*showCartMap.get(id).getAmount();
			}
			cart.setTotalPrice(newTotlePrice);
			cart.setSavePrice(newAllPrice-newTotlePrice);
			cart.setShowCartMap(showCartMap);
			//将map存入session作用域中
			//vs.setValue("#session.showCartMap", showCartMap);
			vs.setValue("#session.cart", cart);
			//return "cart_list";
		}
		return "cart_list";
	}
	//变更购物车数量
	public String updateCartItem(){
		//从session中获取购物车
		ValueStack vs = ActionContext.getContext().getValueStack();
		Cart cart = (Cart) vs.findValue("#session.cart");
		//更改购物车中购物项的数量
		//System.out.println(bookId);
		cart.getShowCartMap().get(bookId.toString()).setAmount(bookCount);
		//重新计算购物车中的总价和节省价格
		HashMap<String,CartItem> showCartMap = cart.getShowCartMap();
		Set<String> bookIds = showCartMap.keySet();
		//总价和节省价
		Double newTotlePrice = 0.0;
		Double newAllPrice = 0.0;
		for (String id : bookIds) {
			newTotlePrice+=bs.queryByBookId(Integer.parseInt(id)).getBookDprice()*showCartMap.get(id).getAmount();
			newAllPrice += bs.queryByBookId(Integer.parseInt(id)).getBookPrice()*showCartMap.get(id).getAmount();
		}
		cart.setTotalPrice(newTotlePrice);
		cart.setSavePrice(newAllPrice-newTotlePrice);
		cart.setShowCartMap(showCartMap);
		//将cart重新放入session作用域中
		vs.setValue("#session.cart", cart);
		//返回购物车页面
		return "cart_list";
	}
	//删除购物车中的购物项
	public String deleteCartItem(){
		try{
		//获取cart
		Cart cart = (Cart) ActionContext.getContext().getValueStack().findValue("#session.cart");
		//System.out.println(cart);
		Book book = bs.queryByBookId(bookId);
		//从showCartMap中移除当前购物项
		CartItem cartItem = cart.getShowCartMap().remove(bookId.toString());
		//将当前购物项添加入恢复map中
		HashMap<String,CartItem> removeCartMap = cart.getRemoveCartMap();
		//判断removeCartMap中是否为空
		if(removeCartMap==null){
			removeCartMap = new HashMap<String, CartItem>();
		}
		removeCartMap.put(bookId.toString(), cartItem);
		//计算总价和节省价
		HashMap<String,CartItem> showCartMap = cart.getShowCartMap();
		Set<String> bookIds = showCartMap.keySet();
		//总价和节省价
		Double newTotlePrice = 0.0;
		Double newAllPrice = 0.0;
		for (String id : bookIds) {
			newTotlePrice+=bs.queryByBookId(Integer.parseInt(id)).getBookDprice()*showCartMap.get(id).getAmount();
			newAllPrice += bs.queryByBookId(Integer.parseInt(id)).getBookPrice()*showCartMap.get(id).getAmount();
		}
		cart.setTotalPrice(newTotlePrice);
		cart.setSavePrice(newAllPrice-newTotlePrice);
		cart.setShowCartMap(showCartMap);
		cart.setRemoveCartMap(removeCartMap);
		//将购物车放入session中
		ActionContext.getContext().getValueStack().setValue("#session.cart", cart);
		return "cart_list"; 
		}catch(Exception e){
			e.printStackTrace();
			return "cart_list";
		}
	}
	//恢复购物车中的购物项
	public String recoverCartItem(){
		try{
		//获取cart
		ValueStack vs = ActionContext.getContext().getValueStack();
		Cart cart = (Cart) vs.findValue("#session.cart");
		//将deleteMap中恢复购物项删除
		CartItem cartItem = cart.getRemoveCartMap().remove(bookId.toString());
		//将showMap中添加恢复的删除购物项
		cart.getShowCartMap().put(bookId.toString(), cartItem);
		//计算showMap中的总价和节省价钱
		HashMap<String,CartItem> showCartMap = cart.getShowCartMap();
		Set<String> bookIds = showCartMap.keySet();
		//总价和节省价
		Double newTotlePrice = 0.0;
		Double newAllPrice = 0.0;
		for (String id : bookIds) {
			//System.out.println(bs.queryByBookId(Integer.parseInt(id)).getBookDprice()*showCartMap.get(id).getAmount());
			newTotlePrice+=bs.queryByBookId(Integer.parseInt(id)).getBookDprice()*showCartMap.get(id).getAmount();
			newAllPrice += bs.queryByBookId(Integer.parseInt(id)).getBookPrice()*showCartMap.get(id).getAmount();
		}
		cart.setTotalPrice(newTotlePrice);
		cart.setSavePrice(newAllPrice-newTotlePrice);
		cart.setShowCartMap(showCartMap);
		cart.setRemoveCartMap(cart.getRemoveCartMap());
	    //重新将cart放入session作用域中
		vs.setValue("#session.cart", cart);
		//跳转返回页面
		return "cart_list";
		}catch(Exception e){
			e.printStackTrace();
			return "cart_list";
		}
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	
}
