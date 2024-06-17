public class ContactList{
	private Node start;
	private boolean isValidIndex(int index){
		return index>=0 && index<=getSize();
	}
	private boolean isEmpty(){
        return start == null; 
    }
    
    public Contact[] toArray(){
		Contact[] tempArray=new Contact[getSize()];
		Node temp=start;
		for (int i = 0; i < tempArray.length; i++){
			tempArray[i]=temp.contacts;
			temp=temp.next;
		}
		return tempArray;
	}

    public Contact get(int index){
        if (isValidIndex(index)) {
            if (index==0) {
                return start.contacts;
            }else{
                Node temp=start;
                for(int i=0; i<index; i++ ){
                    temp = temp.next;
                }
                return temp.contacts;
            }
        }
        return null;
    }
	//-------------Add method---------
	public void add(Contact contact){
		Node n1 = new Node(contact); 
        Node lastNode=start;
        if (isEmpty()) {
            start=n1;
        }else{
            while (lastNode.next!=null) {
                lastNode=lastNode.next; 
            }
            lastNode.next=n1;
        }
	}
    // ----------------getsize-------------------
    public int getSize(){
         Node temp=start;
         int count = 0;
         while (temp!=null) {
            count++; 
            temp=temp.next;
         }
         return count;
    }
	//---------------------------SEARCH METHOD--------------------------
    public int searchByNameOrPhoneNumber(String nameOrPhone){
       Node temp = start;
       int index = 0;
       while (temp!=null) {
        if (temp.contacts.getName().equals(nameOrPhone) || temp.contacts.getPhoneNumber().equals(nameOrPhone)) {
            return index;
        }
        temp=temp.next;
        index++;
       }
        return -1;
    }

	public void updateName(int index, String name){
		get(index).setName(name);
	}
	public void updatePhoneNumber(int index, String phoneNumber){
		get(index).setPhoneNumber(phoneNumber);
	}
    public void updateCompanyName(int index, String newCompanyName){
		get(index).setCompanyName(newCompanyName);
	}
    public void updateSalary(int index, double  newCompanyName){
		get(index).setSalary(newCompanyName);
	}
	//---------------------------DELETE-------------------------------
	public void remove(int index){
		if(index>=0 && index<getSize()){
			if(index==0){
				start=start.next;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					count++;
					temp=temp.next;
				}
				temp.next=temp.next.next;
			}
		}
		
	}


        //-------------------------Salary SORT---------------------------
        public void sortingBySalary(){
            Node temp= start, index = null;
            if (start==null) {
                return;
            }else{
                while (temp!=null) {
                    index=temp.next;

                    while (index!=null) {
                        if (temp.contacts.getSalary()>index.contacts.getSalary()) {
                            Contact tempContact=temp.contacts;
                            temp.contacts=index.contacts;
                            index.contacts=tempContact;

                        }
                        index = index.next;
                    }
                    temp=temp.next;
                }
            }
            for(int i=0; i<getSize(); i++) {
                System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(i).getId(),get(i).getName(),get(i).getPhoneNumber(),get(i).getCompanyName(),get(i).getSalary(),get(i).getBirthday());
            }
        }


        //-------------------------NAME SORT---------------------------
        public void sortingByName(){
            Node temp= start, index = null;
            if (start==null) {
                return;
            }else{
                while (temp!=null) {
                    index=temp.next;

                    while (index!=null) {
                        if (temp.contacts.getName().compareTo(index.contacts.getName())>0) {
                            Contact tempContact=temp.contacts;
                            temp.contacts=index.contacts;
                            index.contacts=tempContact;

                        }
                        index = index.next;
                    }
                    temp=temp.next;
                }
            }
    
            for(int i=0; i<getSize(); i++) {
                System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(i).getId(),get(i).getName(),get(i).getPhoneNumber(),get(i).getCompanyName(),get(i).getSalary(),get(i).getBirthday());
            }
    
        }



            //-------------------------BIRTHDAY SORT---------------------------
     public void sortingByBirthday(){
		
		Node temp= start, index = null;
            if (start==null) {
                return;
            }else{
                while (temp!=null) {
                    index=temp.next;

                    while (index!=null) {
                        if (temp.contacts.getBirthday().compareTo(index.contacts.getBirthday())>0) {
                            Contact tempContact=temp.contacts;
                            temp.contacts=index.contacts;
                            index.contacts=tempContact;

                        }
                        index = index.next;
                    }
                    temp=temp.next;
                }
            }

            for(int i=0; i<getSize(); i++) {
                System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(i).getId(),get(i).getName(),get(i).getPhoneNumber(),get(i).getCompanyName(),get(i).getSalary(),get(i).getBirthday());
            }

    }

    

    //-----------------------Node class--------------------------------- 
    class Node{
        private Contact contacts;
        private Node next;

        Node (Contact contacts){
            this.contacts=contacts;
        }
    }
}