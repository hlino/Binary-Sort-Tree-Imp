/*Harrison Linowes
 * this program creates a Binary Search Tree 
 * the program contains methods to add and remove treeNodes from the tree
 * it also maintains data in order from least to greatest
 */
public class Linowes_Bianry_Search_Tree<E extends Comparable<E>>{

	//binary tree inner class
	public class TreeNode{

		private E data;
		private int frequency;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(E d, TreeNode l,TreeNode r, int f){
			data=d;
			left=l;
			right=r;
			frequency=f;
		}
	}

	private TreeNode root;

	//prints the tree in order
	public void inOrder(){

		recurseInOrder(root);
	}

	//helper method uses recursion to print tree in order
	private void recurseInOrder(TreeNode r){

		if(r!=null){

			recurseInOrder(r.left);

			for(int i=0;i<r.frequency;i++){
				System.out.print(r.data+", ");
			}

			recurseInOrder(r.right);
		}
	}

	//prints the tree in preorder
	public void preOrder(){

		recursePreOrder(root);
	}

	//helper method uses recursion to print tree in preorder
	private void recursePreOrder(TreeNode r){

		if(r!=null){

			for(int i=0;i<r.frequency;i++){
				System.out.print(r.data+", ");
			}

			recursePreOrder(r.left);
			recursePreOrder(r.right);
		}
	}

	//prints the tree in postorder
	public void postOrder(){

		recursePostOrder(root);
	}

	//helper method uses recursion to print tree in postorder
	private void recursePostOrder(TreeNode r){

		if(r!=null){

			recursePostOrder(r.left);
			recursePostOrder(r.right);

			for(int i=0;i<r.frequency;i++){
				System.out.print(r.data+", ");
			}
		}
	}

	//returns true if the tree contains the parameter element
	public boolean conatains(E item){

		return recurseContains(item, root);
	}

	//recursive helper method to find if tree contains element
	private boolean recurseContains(E item,TreeNode r){

		if(r==null){
			return false;
		}
		if(item.compareTo(r.data)==0){

			return true;
		}

		if(item.compareTo(r.data)>0){

			return recurseContains(item,r.right);
		}
		else{

			return recurseContains(item, r.left);
		}
	}

	//find the smallest element and returns it
	public E findMin(){

		return recursefindMin(root);
	}

	//recursive helper method to find the smallest element
	private E recursefindMin(TreeNode r){

		if(r==null)
			return null;

		if(r.left==null)
			return r.data;

		return recursefindMin(r.left);
	}

	//returns the largest element in the tree
	public E findMax(){

		return recurseFindMax(root);
	}

	//recursive helper method returns the largest element
	private E recurseFindMax(TreeNode r){

		if(r==null)
			return null;

		if(r.right==null)
			return r.data;

		return recurseFindMax(r.right);
	}

	//inserts the element in the tree at the correct position
	public void insert(E item){

		root=recurseInsert(root,item);
	}

	//recursive helper method recursively finds the spot then inserts the element
	private TreeNode recurseInsert(TreeNode r, E item){

		if(r==null){

			r=new TreeNode(item,null,null,1);
		}
		else if(item.compareTo(r.data)>0){

			r.right=recurseInsert(r.right,item);
		}
		else if(item.compareTo(r.data)<0){

			r.left=recurseInsert(r.left,item);
		}
		else{

			r.frequency+=1;
		}

		return r;
	}

	//removes the element from the tree
	public void remove(E item){

		root=removeHelper(root,item);
	}

	//recursive helper method returns the new root
	private TreeNode removeHelper(TreeNode r, E item){

		if(r==null){

			return null;
		}

		if(item.compareTo(r.data)==0){

			return removeNode(r);
		}
		else if(r.data.compareTo(item)>0){

			r.left=removeHelper(r.left,item);
		}
		else{

			r.right=removeHelper(r.right,item);
		}

		return r;
	}

	//private helper method returns state of the subtree after determining the number of children
	private TreeNode removeNode(TreeNode spot){

		//if the element has more than one frequency
		if(spot.frequency>1){

			spot.frequency--;
			return spot;
		}
		//if the element is a leaf
		else if(spot.left==null&&spot.right==null){

			spot=null;

			return null;
		}
		//if the element only has a right child
		else if(spot.left==null){

			return spot.right;
		}
		//if the element only has a left child
		else if(spot.right==null){

			return spot.left;
		}
		//if the element has two children
		else{

			E min=this.recursefindMin(spot.right);

			remove(min);

			spot.data=min;

			return spot;
		}
	}
}