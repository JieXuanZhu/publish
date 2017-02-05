package cn.com.shukaiken.util.tree.etree;

import java.util.ArrayList;
import java.util.List;
public class EuiTreeJsonS{
    public static List<EuiTreeNodeS> formatTree(List<EuiTreeNodeS> list) {
        EuiTreeNodeS root = new EuiTreeNodeS();
        EuiTreeNodeS node = new EuiTreeNodeS();
        List<EuiTreeNodeS> treelist = new ArrayList<EuiTreeNodeS>();
        List<EuiTreeNodeS> parentnodes = new ArrayList<EuiTreeNodeS>();
        
        if (list != null && list.size() > 0) {
            root = list.get(0) ;
            for (int i = 1; i < list.size(); i++) {
                node = list.get(i);
                if(node.getPid().equals(root.getId())){
                    parentnodes.add(node) ;
                    root.getChildren().add(node) ;
                }else{
                    getChildrenNodes(parentnodes, node);
                    parentnodes.add(node) ;
                }
            }    
        }
        treelist.add(root) ;
        System.out.println(treelist);
        return treelist ;

    }

    private static void getChildrenNodes(List<EuiTreeNodeS> parentnodes, EuiTreeNodeS node) {
        for (int i = parentnodes.size() - 1; i >= 0; i--) {
            
            EuiTreeNodeS pnode = parentnodes.get(i);
            if (pnode.getId().equals(node.getPid())) {
                pnode.setState("closed") ;
                pnode.getChildren().add(node) ;
                return ;
            } else {
                parentnodes.remove(i) ;
            }
        }
    }
    
    
    
    public static List<EuiTreeNodeS> buildtree(List<EuiTreeNodeS> nodes,String id){
		List<EuiTreeNodeS> treeNodes=new ArrayList<EuiTreeNodeS>();
		for (EuiTreeNodeS treeNode : nodes) {
			EuiTreeNodeS node=new EuiTreeNodeS();
			node.setId(treeNode.getId());
			node.setPid(treeNode.getPid());
			node.setText(treeNode.getText());
			node.setChecked(treeNode.isChecked());
			node.setState(treeNode.getState());
			node.setIconCls(treeNode.getIconCls());
			node.setTarget(treeNode.getTarget());
			node.setAttributes(treeNode.getAttributes());
			
			if((id).equals(treeNode.getPid())){
				node.setChildren(buildtree(nodes, node.getId()));
				treeNodes.add(node);
			}
		}
		return treeNodes;
	}

}