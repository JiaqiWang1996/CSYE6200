//package edu.neu.csye6200;
//
//public class HiTechItemFactory extends AbstractItemFactory{
//
//	@Override
//	public AbstractItem getObject() {
//		// TODO Auto-generated method stub
//		return new HiTechItem();
//	}
//
//	@Override
//	public AbstractItem getObject(String csvData) {
//		// TODO Auto-generated method stub
//		return new HiTechItem();
//	}
//
//}
package edu.neu.csye6200;

public class HiTechItemFactory extends AbstractItemFactory{

    @Override
    public AbstractItem getObject() {
        return HiTechItem.getObject();
    }

    @Override
    public AbstractItem getObject(String csvData) {
        return HiTechItem.getObject(csvData);
    }
}
