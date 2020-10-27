//package edu.neu.csye6200;
//
//public class CartFactory extends AbstractCartFactory{
//
//	@Override
//	public Cart getObject() {
//		// TODO Auto-generated method stub
//		return new MobileShopperCart();
//	}
//
//	@Override
//	public Cart getObject(String csvData) {
//		// TODO Auto-generated method stub
//		return new MobileShopperCart();
//	}
//
//}
package edu.neu.csye6200;

public class CartFactory extends AbstractCartFactory {

    @Override
    public Cart getObject() {
        return MobileShopperCart.getObject();
    }

    @Override
    public Cart getObject(String csvData) {
        return MobileShopperCart.getObject(csvData);
    }
}

