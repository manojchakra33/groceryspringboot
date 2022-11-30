package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroceryDao {

	@Autowired
	LoginRepository loginRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	OrdersRepository ordersRepo;

	@Autowired
	ProductRepository productRepo;

	public Boolean findUserId(String userName) {

		List<Login> login = loginRepo.findAll();
		for (Login l : login) {
			if (l.getUserName().equals(userName)) {
				return false;
			}

		}
		return true;
	}

	public Category setCategory(String catrgory) {
		Category c = new Category();
		c.setCategoryName(catrgory);
		return categoryRepo.save(c);
	}

	public Category findCategory(String name) {
		return categoryRepo.findByCategoryName(name);

	}

	public Category deleteCategory(String name) {
		Category c = categoryRepo.findByCategoryName(name);
		categoryRepo.deleteById(c.getCategoryId());
		return c;
	}

	public Boolean checkMobileNum(String string) {
		List<User> user = userRepo.findAll();
		for (User u : user) {
			if (u.getMobileNumber().equals(string)) {
				if (string.length() < 10 && string.length() > 10) {
					return false;
				}
			}
		}
		return true;

	}

	// in progress
	public List<TopSold> topSell() {
		List<Orders> orders = ordersRepo.findAll();
		List<Product> soldProducts = new ArrayList<>();
		List<TopSold> set = new ArrayList<>();// unordered
		List<TopSold> setLast = new ArrayList<>();// ordered

		for (Orders o : orders) {
			List<Product> product = o.getProduct();
			for (Product p : product) {
				soldProducts.add(p);
			}
		}

		for (Product s : soldProducts) {
			TopSold t2 = new TopSold();
			t2.setProductId(s.getProductId());
			t2.setProductName(s.getProductName());
			t2.setTotalSold(s.getCost());
			set.add(t2);
		}

		for (TopSold ts : set) {
			if (setLast.isEmpty()) {
				setLast.add(ts);
			} else {
				for (TopSold tsl : setLast) {
					int id = tsl.getProductId();
					if (ts.equals(id)) {
						TopSold tss = ts;
						tss.setTotalSold(tss.getTotalSold() + ts.getTotalSold());
						tsl.setTotalSold(tss.getTotalSold());

					} else {
						setLast.add(ts);
					}
				}
			}
		}

		return setLast;
	}

	public List<Orders> findOrders(String userName) {
		Login l = loginRepo.findById(userName).get();
		User u = userRepo.findBylogin(l);

		List<Orders> orders = ordersRepo.findByUser(u);
		return orders;

	}

	public List<Product> findProductsByName(String name) {
		List<Product> products = productRepo.findAll();
		List<Product> sortedProductsByName = new ArrayList<>();

		for (Product p : products) {
			if (p.getProductName().toLowerCase().equals(name.toLowerCase())) {
				sortedProductsByName.add(p);
			}
		}
		return sortedProductsByName;
	}

//	public Boolean delProductFromOrder(int orderId, int productId) {
//		List<Orders> orders = ordersRepo.findAll();
//		for (Orders o : orders) {
//			if (o.getOrderId() == orderId) {
//				List<Product> products = o.getProduct();
//				for (Product p : products) {
//					  Product product=productRepo.getById(productId);
//					if (p.equals(product)) {
//						products.remove(p);								
//					}
//				}
//				o.setProduct(products);	   
//			}
//			System.out.println(o);
//			ordersRepo.save(o);
//			return true;
//		}
//		
//		return false;
//
//	}

}
