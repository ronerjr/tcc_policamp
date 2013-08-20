/**
 * 
 */
package com.onfocus.jfood.util;

import java.util.List;

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
public interface GenericDAO {
	// ***************************************************
	// Ações para usuários
	// ***************************************************

	/**
	 * Método para inserção de usuário no banco do dados
	 * 
	 * @param usuário
	 * @return usuário
	 */
	public User insertUser(User user);

	/**
	 * Método para alteração de usuário no banco do dados
	 * 
	 * @param usuário
	 * @return usuário
	 */
	public User updateUser(User user);

	/**
	 * Método para remoção de usuário no banco do dados
	 * 
	 * @param usuário
	 */
	public void deleteUser(User user);

	/**
	 * Método para encontrar usuário no banco do dados pelo identificador
	 * 
	 * @param id
	 * @return usuário
	 */
	public User findUserById(String id);

	/**
	 * Método para encontrar usuário no banco do dados pelo nome
	 * 
	 * @param nome
	 * @return usuário
	 */
	public User findUserByUsername(String name);

	/**
	 * Método para encontrar usuário no banco do dados pelo email
	 * 
	 * @param email
	 * @return usuário
	 */
	public User findUserByEmail(String email);

	/**
	 * Método para listar os usuários no banco do dados por tipo
	 * 
	 * @param tipo
	 * @return lista de usuários
	 */
	public List<User> listUserByType(UserType type);

	/**
	 * Método para listar usuários no banco do dados
	 * 
	 * @return lista de usuários
	 */
	public List<User> listAllUsers();

	// ***************************************************
	// Ações para fornecedores
	// ***************************************************

	public Supplier insertSupplier(Supplier supplier);

	public Supplier updateSupplier(Supplier supplier);

	public void deleteSupplier(Supplier supplier);

	public Supplier findSupplierById(long id);

	public Supplier findSupplierByCNPJ(String cnpj);

	public List<Supplier> listSupplierByName(String tradingName);

	public List<Supplier> listAllSuppliers();

	// ***************************************************
	// Ações para pedidos
	// ***************************************************

	public Order insertInvoice(Order order);

	public Order updateInvoice(Order order);

	public void deleteInvoice(Order order);

	public void closeInvoice(Order order);

	public List<Order> listInvoiceByTable(Tables table);

	public List<Order> listInvoiceProductsByTable(Tables table);

	public List<Order> listInvoiceByStatus(OrderStatus status);

	public List<Order> listInvoiceById(Order order);

	public List<Order> listAllOpenInvoices();

	// ***************************************************
	// Ações para produtos
	// ***************************************************

	public Product insertProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(Product product);

	public Product findProductById(long id);

	public Product findProductByName(String name);

	public List<Product> listProductByType(ProductType productType);

	public List<Product> listAllProductsEnable();

	public List<Product> listAllProducts();

	// ***************************************************
	// Ações para status dos pedidos
	// ***************************************************
	public OrderStatus insertStatus(OrderStatus status);

	public OrderStatus updateStatus(OrderStatus status);

	public void deleteStatus(OrderStatus status);

	public OrderStatus findStatusById(long id);

	public OrderStatus findStatusByStatus(String status);

	public List<OrderStatus> listAllStatus();

	// ***************************************************
	// Ações para tipo do produtos
	// ***************************************************
	public ProductType insertProductType(ProductType productType);

	public ProductType updateProductType(ProductType productType);

	public void deleteProductType(ProductType productType);

	public ProductType findProductTypeById(long id);

	public List<ProductType> listAllProductTypes();

	// ***************************************************
	// Ações para tipo de usuarios
	// ***************************************************
	public UserType insertUserType(UserType tipo);

	public UserType updateUserType(UserType tipo);

	public void deleteUserType(UserType tipo);

	public UserType findUserTypeById(long id);

	public UserType findUserTypeByType(String tipo);

	public List<UserType> listAllUserTypes();

	// ***************************************************
	// Ações para tipos de pedidos
	// ***************************************************
	public OrderType insertInvoiceType(OrderType orderType);

	public OrderType updateInvoiceType(OrderType orderType);

	public void deleteInvoiceType(OrderType orderType);

	public OrderType findInvoiceTypeByType(String type);

	public List<OrderType> listAllInvoiceTypes();

	// ***************************************************
	// Ações para unidades de medida
	// ***************************************************

	public MeasureUnity insertMeasureUnit(MeasureUnity measureUnity);

	public MeasureUnity updateMeasureUnit(MeasureUnity measureUnity);

	public void deleteMeasureUnit(MeasureUnity measureUnity);

	public MeasureUnity findMeasureUnitById(String id);

	public List<MeasureUnity> listMeasureUnitByUnit(String measureUnity);

	public List<MeasureUnity> listAllMeasureUnits();

	// ***************************************************
	// Ações para complementos
	// ***************************************************

	public List<Complement> listAllComplements();

	public List<Complement> listComplementsByType(ProductType tipoProduto);

	public Complement findComplementById(Long id);

	public Complement insertComplement(Complement complements);

	public Complement updateComplement(Complement complements);

	public void deleteComplement(Complement complements);

	// ***************************************************
	// Ações para formas de pagamento
	// ***************************************************

	public List<PaymentMode> listAllPaymentMode();

	public PaymentMode findPaymentMode(Long id);

	public PaymentMode insertPaymentMode(PaymentMode paymentMode);

	public PaymentMode updatePaymentMode(PaymentMode paymentMode);

	public void deletePaymentMode(PaymentMode paymentMode);

	// ***************************************************
	// Ações para mesas
	// ***************************************************

	public List<Tables> listAllTables();

	public Tables findMesaByNumber(Long number);

	public Tables insertMesa(Tables table);

	public Tables updateMesa(Tables table);

	public void deleteMesa(Tables table);

	public Long invoiceNextValue();
}