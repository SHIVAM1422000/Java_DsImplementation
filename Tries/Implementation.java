public class Implementation {
    Tries root=null;


public static void insert(Tries root,String str){
   
     if(str.length()==1){
         root.isEnd=true;
         return;
     }

    int pos=str.charAt(0)-'a';
    if(root.children[pos]==null){ 
       Tries tail=new Tries();
       insert(tail,str.substring(1));
       root.children[pos]=tail; 
    }else{
       insert(root.children[pos],str.substring(1)); 
    }
        
}



public static boolean search(Tries root,String str){

   if(str.length()==0) return true;
    
   if(str.length()==1){
      
        //    System.out.println("Word status:"+str.charAt(0)+" : "+root.isEnd);
           return root.isEnd;
     
   }


   int pos=str.charAt(0)-'a';
   if(root.children[pos]==null){
       return false;
   }else{
    //    System.out.println("Found Character= "+str.charAt(0));
       return search(root.children[pos],str.substring(1));
   }


}


 
public static void main(String[] args) {

  Tries root=new Tries();  
 insert(root,"sitar");
 insert(root,"sita");
 insert(root,"ram");

 System.out.println("Search Result For String: "+"sit= "+search(root,"sit"));
 System.out.println("Search Result For String: "+"sita= "+search(root,"sita"));
 System.out.println("Search Result For String: "+"sitar= "+search(root,"sitar"));
 System.out.println("Search Result For String: "+"sitam= "+search(root,"sitam"));
 System.out.println("Search Result For String: "+"ram= "+search(root,"ram"));
 System.out.println("Search Result For String: "+"sitaram= "+search(root,"ram"));

//  System.out.println("Search Result: "+search(root,"ram"));

}
}
