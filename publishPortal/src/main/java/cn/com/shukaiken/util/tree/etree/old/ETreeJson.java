package cn.com.shukaiken.util.tree.etree.old;

import java.util.ArrayList;
import java.util.List;
/**
 * [{   
    "id":1,   
    "text":"Folder1",   
    "iconCls":"icon-save",   
    "children":[{   
        "text":"File1",   
        "checked":true  
    }]   
}] 
 * ETreeNode.formatTree(ETreeNodelist) ;
 * @author lwb
 *
 */
public class ETreeJson{
    
    /******** setter and getter **********/

    public static List<ETreeNode> formatTree(List<ETreeNode> list) {
        ETreeNode root = new ETreeNode();
        ETreeNode node = new ETreeNode();
        List<ETreeNode> treelist = new ArrayList<ETreeNode>();// 鎷煎噾濂界殑json鏍煎紡鐨勬暟鎹�
        List<ETreeNode> parentnodes = new ArrayList<ETreeNode>();// parentnodes瀛樻斁鎵�湁鐨勭埗鑺傜偣
        
        if (list != null && list.size() > 0) {
            root = list.get(0) ;
            for (int i = 1; i < list.size(); i++) {
                node = list.get(i);
                if(node.getPid().equals(root.getId())){
                    //涓簍ree root 澧炲姞瀛愯妭鐐�
                    parentnodes.add(node) ;
                    root.getChildren().add(node) ;
                }else{//鑾峰彇root瀛愯妭鐐圭殑瀛╁瓙鑺傜偣
                    getChildrenNodes(parentnodes, node);
                    parentnodes.add(node) ;
                }
            }    
        }
        treelist.add(root) ;
        System.out.println(treelist);
        return treelist ;

    }

    private static void getChildrenNodes(List<ETreeNode> parentnodes, ETreeNode node) {
        //寰幆閬嶅巻鎵�湁鐖惰妭鐐瑰拰node杩涜鍖归厤锛岀‘瀹氱埗瀛愬叧绯�
        for (int i = parentnodes.size() - 1; i >= 0; i--) {
            
            ETreeNode pnode = parentnodes.get(i);
            //濡傛灉鏄埗瀛愬叧绯伙紝涓虹埗鑺傜偣澧炲姞瀛愯妭鐐癸紝閫�嚭for寰幆
            if (pnode.getId().equals(node.getPid())) {
                pnode.setState("closed") ;//鍏抽棴浜岀骇鏍�
                pnode.getChildren().add(node) ;
                return ;
            } else {
                //濡傛灉涓嶆槸鐖跺瓙鍏崇郴锛屽垹闄ょ埗鑺傜偣鏍堥噷褰撳墠鐨勮妭鐐癸紝
                //缁х画姝ゆ寰幆锛岀洿鍒扮‘瀹氱埗瀛愬叧绯绘垨涓嶅瓨鍦ㄩ�鍑篺or寰幆
                parentnodes.remove(i) ;
            }
        }
    }
    
    
    
    public static List<ETreeNode> buildtree(List<ETreeNode> nodes,Integer id){
		List<ETreeNode> treeNodes=new ArrayList<ETreeNode>();
		for (ETreeNode treeNode : nodes) {
			ETreeNode node=new ETreeNode();
			node.setId(treeNode.getId());
			node.setText(treeNode.getText());
			if(id==treeNode.getPid()){
				node.setChildren(buildtree(nodes, node.getId()));
				treeNodes.add(node);
			}
		}
		return treeNodes;
	}

}