package cn.com.shukaiken.util.tree.etree;

import java.util.ArrayList;
import java.util.List;
/**
 * @author lwb
 *
 */
public class EuiTreeJsonL{
    public static List<EuiTreeNodeL> formatTree(List<EuiTreeNodeL> list) {
        EuiTreeNodeL root = new EuiTreeNodeL();
        EuiTreeNodeL node = new EuiTreeNodeL();
        List<EuiTreeNodeL> treelist = new ArrayList<EuiTreeNodeL>();
        List<EuiTreeNodeL> parentnodes = new ArrayList<EuiTreeNodeL>();
        
        if (list != null && list.size() > 0) {
            root = list.get(0) ;
            for (int i = 1; i < list.size(); i++) {
                node = list.get(i);
                if(node.getPid().equals(root.getId())){
                    parentnodes.add(node) ;
                    root.getChildren().add(node);
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

    private static void getChildrenNodes(List<EuiTreeNodeL> parentnodes, EuiTreeNodeL node) {
        for (int i = parentnodes.size() - 1; i >= 0; i--) {
            
            EuiTreeNodeL pnode = parentnodes.get(i);
            if (pnode.getId().equals(node.getPid())) {
                pnode.setState("closed") ;
                pnode.getChildren().add(node) ;
                return ;
            } else {
                parentnodes.remove(i) ;
            }
        }
    }
    
    public static List<EuiTreeNodeL> buildtree(List<EuiTreeNodeL> nodes,Long id){
		List<EuiTreeNodeL> treeNodes=new ArrayList<EuiTreeNodeL>();
		for (EuiTreeNodeL treeNode : nodes) {
			EuiTreeNodeL node=new EuiTreeNodeL();
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