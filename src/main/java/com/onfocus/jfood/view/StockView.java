package com.onfocus.jfood.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.util.ComponentUtils;

import sun.java2d.loops.DrawGlyphListAA.General;

import com.onfocus.jfood.helper.StockHelper;
import com.onfocus.jfood.model.StockControl;
import com.onfocus.jfood.util.DAOFactory;
import com.onfocus.jfood.util.GenericDAO;

@ManagedBean(name = "stockView")
@SessionScoped
public class StockView implements Serializable {

	private static final long serialVersionUID = 1L;

	private StockControl persistStock;

	private List<StockControl> filteredStock;
	
	private StockControl selectedStock;

	private StockHelper stockHelper;

	public StockView() {
		stockHelper = new StockHelper();
	}

	public String preparePersist() {
		this.persistStock = new StockControl();
		return "/protected/admin/adminPersistStock.jsf";
	}

	public String prepareUpdate() {
		this.persistStock = this.selectedStock;
		return "/protected/admin/adminPersistStock.jsf";
	}

	public void update() {
		if (this.stockHelper.validateInsert(this.persistStock)) {
			// DUVIDA SOBRE PERMISSAO
			//this.stockHelper.setAuthorityByType(this.persistStock);
			if (DAOFactory.getService().updateStock(this.persistStock) == this.persistStock) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Item alterado com sucesso!", "SUCESSO"));
				
				this.persistStock = new StockControl();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao alterar item", "ERROR"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao alterar item", "ERROR"));
		}
	}

//	public void insert() {
//		if (this.userHelper.validateInsert(this.persistUser)) {
//			this.persistUser.setPermission(this.userHelper.setAuthorityByType(
//					this.persistUser).name());
//			if (DAOFactory.getService().insertUser(this.persistUser) == this.persistUser) {
//				FacesContext.getCurrentInstance().addMessage(
//						null,
//						new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario "
//								+ this.persistUser.getUserName()
//								+ " inserido com sucesso!", "SUCESSO"));
//				this.persistUser = new User();
//			} else {
//				FacesContext.getCurrentInstance().addMessage(
//						null,
//						new FacesMessage(FacesMessage.SEVERITY_ERROR,
//								"Erro ao inserir usu�rio", "ERRO"));
//			}
//		} else {
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Erro ao inserir usu�rio", "ERRO"));
//		}
//	}

	
	/**
	 * @return the persistUser
	 */
	public StockControl getPersistStock() {
		return persistStock;
	}

	/**
	 * @param persistUser
	 *            the persistUser to set
	 */
	public void setPersistStock(StockControl persistStock) {
		this.persistStock = persistStock;
	}

	/**
	 * @return the selectedItem
	 */
	public StockControl getSelectedStock() {
		return selectedStock;
	}

	/**
	 * @param selectedItem
	 *            the selectedItem to set
	 */
	public void setSelectedStock(StockControl selectedStock) {
		this.selectedStock = selectedStock;
	}

	/**
	 * @return the userHelper
	 */
	public StockHelper getStockHelper() {
		return stockHelper;
	}

	/**
	 * @param userHelper
	 *            the userHelper to set
	 */
	public void setStockHelper(StockHelper stockHelper) {
		this.stockHelper = stockHelper;
	}
	
	public List<StockControl> getFilteredStock() {
        return DAOFactory.getService().filteredStock();  
    }  
  
    public void setFilteredStock(List<StockControl> filteredStock) {  
        this.filteredStock = filteredStock;  
     }
    
}