
public class Driver {
	
	public static void main(String[] args){
		
		Linowes_Bianry_Search_Tree <Integer >tree=new Linowes_Bianry_Search_Tree<Integer>();
		
		tree.insert(10);
		tree.insert(4);
		tree.insert(4);
		tree.insert(15);
		tree.insert(3);
		tree.insert(16);
		tree.insert(12);
		tree.insert(13);
		/*tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(7);*/
		
		tree.postOrder();
		/*System.out.println();
		tree.preOrder();
		System.out.println();
		tree.postOrder();
		System.out.println("\n"+tree.findMin());*/
		
		tree.remove(4);
		System.out.println();
		
		tree.inOrder();
		
		/*int g=5;
		int i=28;*/
		
		//System.out.print("COMPARE:"+((Integer)g).compareTo(i));
	}

}
