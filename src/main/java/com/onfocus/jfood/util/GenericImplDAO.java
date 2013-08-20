/**
 * 
 */
package com.onfocus.jfood.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.onfocus.jfood.model.Complement;
import com.onfocus.jfood.model.MeasureUnity;
import com.onfocus.jfood.model.Order;
import com.onfocus.jfood.model.OrderStatus;
import com.onfocus.jfood.model.OrderType;
import com.onfocus.jfood.model.PaymentMode;
import com.onfocus.jfood.model.Product;
import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.model.Supplier;
import com.onfocus.jfood.model.Tables;
import com.onfocus.jfood.model.User;
import com.onfocus.jfood.model.UserType;

/**
 * @author Roner
 * 
 */
public class GenericImplDAO implements GenericDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public User insertUser(User user) {
		this.session.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		this.session.merge(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		this.session.delete(user);
	}

	@Override
	public User findUserById(String id) {
		return (User) this.session.get(User.class, id);
	}

	@Override
	public User findUserByUsername(String user) {
		return (User) this.session.createCriteria(User.class).add(
				Restrictions.eqProperty("user_name", user));
	}

	@Override
	public User findUserByEmail(String email) {
		return (User) this.session.createCriteria(User.class)
				.add(Restrictions.eq("user_email", email)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUserByType(UserType type) {
		return this.session.createCriteria(User.class)
				.add(Restrictions.eq("id_user_type", type.getId())).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listAllUsers() {
		return this.session.createCriteria(User.class).list();
	}

	@Override
	public Supplier insertSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public Supplier findSupplierById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier findSupplierByCNPJ(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> listSupplierByName(String tradingName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> listAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order insertInvoice(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateInvoice(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInvoice(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInvoice(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> listInvoiceByTable(Tables table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listInvoiceProductsByTable(Tables table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listInvoiceByStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listInvoiceById(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listAllOpenInvoices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product insertProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductByType(ProductType productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listAllProductsEnable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus insertStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus updateStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStatus(OrderStatus status) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderStatus findStatusById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus findStatusByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderStatus> listAllStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductType insertProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductType updateProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductType(ProductType productType) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductType findProductTypeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductType> listAllProductTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType insertUserType(UserType type) {
		this.session.save(type);
		return type;
	}

	@Override
	public UserType updateUserType(UserType type) {
		this.session.update(type);
		return type;
	}

	@Override
	public void deleteUserType(UserType type) {
		this.session.delete(type);
	}

	@Override
	public UserType findUserTypeById(long id) {
		return (UserType) this.session.get(UserType.class, id);
	}

	@Override
	public UserType findUserTypeByType(String type) {
		return (UserType) this.session.createCriteria(UserType.class).add(
				Restrictions.eqProperty("user_type", type));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserType> listAllUserTypes() {
		return this.session.createCriteria(UserType.class).list();
	}

	@Override
	public OrderType insertInvoiceType(OrderType orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderType updateInvoiceType(OrderType orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInvoiceType(OrderType orderType) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderType findInvoiceTypeByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderType> listAllInvoiceTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeasureUnity insertMeasureUnit(MeasureUnity measureUnity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeasureUnity updateMeasureUnit(MeasureUnity measureUnity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMeasureUnit(MeasureUnity measureUnity) {
		// TODO Auto-generated method stub

	}

	@Override
	public MeasureUnity findMeasureUnitById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MeasureUnity> listMeasureUnitByUnit(String measureUnity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MeasureUnity> listAllMeasureUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Complement> listAllComplements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Complement> listComplementsByType(ProductType tipoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complement findComplementById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complement insertComplement(Complement complements) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complement updateComplement(Complement complements) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComplement(Complement complements) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PaymentMode> listAllPaymentMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMode findPaymentMode(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMode insertPaymentMode(PaymentMode paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMode updatePaymentMode(PaymentMode paymentMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePaymentMode(PaymentMode paymentMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tables> listAllTables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tables findMesaByNumber(Long number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tables insertMesa(Tables table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tables updateMesa(Tables table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMesa(Tables table) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long invoiceNextValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
