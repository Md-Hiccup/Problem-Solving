package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartIDEComments {

    public static void main(String[] args) {
        String str = "#include<stdio.h>\n" +
                "#include<stdlib.h>\n" +
                "typedef struct Node\n" +
                "{\n" +
                "        int data;\n" +
                "        struct Node *next;\n" +
                "        struct Node *prev;\n" +
                "}node;\n" +
                "void insert(node *pointer, int data)\n" +
                "{\n" +
                "        /* Iterate through the list till we encounter the last node.*/\n" +
                "        while(pointer->next!=NULL)\n" +
                "        {\n" +
                "                pointer = pointer -> next;\n" +
                "        }\n" +
                "        /* Allocate memory for the new node and put data in it.*/\n" +
                "        pointer->next = (node *)malloc(sizeof(node));\n" +
                "        (pointer->next)->prev = pointer;\n" +
                "        pointer = pointer->next;\n" +
                "        pointer->data = data;\n" +
                "        pointer->next = NULL;\n" +
                "}\n" +
                "int find(node *pointer, int key)\n" +
                "{\n" +
                "        pointer =  pointer -> next; //First node is dummy node.\n" +
                "        /* Iterate through the entire linked list and search for the key. */\n" +
                "        while(pointer!=NULL)\n" +
                "        {\n" +
                "                if(pointer->data == key) //key is found.\n" +
                "                {\n" +
                "                        return 1;\n" +
                "                }\n" +
                "                pointer = pointer -> next;//Search in the next node.\n" +
                "        }\n" +
                "        /*Key is not found */\n" +
                "        return 0;\n" +
                "}\n" +
                "void delete(node *pointer, int data)\n" +
                "{\n" +
                "        /* Go to the node for which the node next to it has to be deleted */\n" +
                "        while(pointer->next!=NULL && (pointer->next)->data != data)\n" +
                "        {\n" +
                "                pointer = pointer -> next;\n" +
                "        }\n" +
                "        if(pointer->next==NULL)\n" +
                "        {\n" +
                "                printf(\"Element %d is not present in the list\\n\",data);\n" +
                "                return;\n" +
                "        }\n" +
                "        /* Now pointer points to a node and the node next to it has to be removed */\n" +
                "        node *temp;\n" +
                "        temp = pointer -> next;\n" +
                "        /*temp points to the node which has to be removed*/\n" +
                "        pointer->next = temp->next;\n" +
                "        temp->prev =  pointer;\n" +
                "        /*We removed the node which is next to the pointer (which is also temp) */\n" +
                "        free(temp);\n" +
                "        /* Beacuse we deleted the node, we no longer require the memory used for it .\n" +
                "           free() will deallocate the memory.\n" +
                "         */\n" +
                "        return;\n" +
                "}\n" +
                "void print(node *pointer)\n" +
                "{\n" +
                "        if(pointer==NULL)\n" +
                "        {\n" +
                "                return;\n" +
                "        }\n" +
                "        printf(\"%d \",pointer->data);\n" +
                "        print(pointer->next);\n" +
                "}\n" +
                "int main()\n" +
                "{\n" +
                "        /* start always points to the first node of the linked list.\n" +
                "           temp is used to point to the last node of the linked list.*/\n" +
                "        node *start,*temp;\n" +
                "        start = (node *)malloc(sizeof(node));\n" +
                "        temp = start;\n" +
                "        temp -> next = NULL;\n" +
                "        temp -> prev = NULL;\n" +
                "        /* Here in this code, we take the first node as a dummy node.\n" +
                "           The first node does not contain data, but it used because to avoid handling special cases\n" +
                "           in insert and delete functions.\n" +
                "         */\n" +
                "        printf(\"1. Insert\\n\");\n" +
                "        printf(\"2. Delete\\n\");\n" +
                "        printf(\"3. Print\\n\");\n" +
                "        printf(\"4. Find\\n\");\n" +
                "        while(1)\n" +
                "        {\n" +
                "                int query;\n" +
                "                scanf(\"%d\",&query);\n" +
                "                if(query==1)\n" +
                "                {\n" +
                "                        int data;\n" +
                "                        scanf(\"%d\",&data);\n" +
                "                        insert(start,data);\n" +
                "                }\n" +
                "                else if(query==2)\n" +
                "                {\n" +
                "                        int data;\n" +
                "                        scanf(\"%d\",&data);\n" +
                "                        delete(start,data);\n" +
                "                }\n" +
                "                else if(query==3)\n" +
                "                {\n" +
                "                        printf(\"The list is \");\n" +
                "                        print(start->next);\n" +
                "                        printf(\"\\n\");\n" +
                "                }\n" +
                "                else if(query==4)\n" +
                "                {\n" +
                "                        int data;\n" +
                "                        scanf(\"%d\",&data);\n" +
                "                        int status = find(start,data);\n" +
                "                        if(status)\n" +
                "                        {\n" +
                "                                printf(\"Element Found\\n\");\n" +
                "                        }\n" +
                "                        else\n" +
                "                        {\n" +
                "                                printf(\"Element Not Found\\n\");\n" +
                "\n" +
                "                        }\n" +
                "                }\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "}";
        StringBuilder strbul = new StringBuilder();
        Scanner in = new Scanner(str);//System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            strbul.append(line.trim()).append("\n");
        }

        Pattern p = Pattern.compile("(?:(//.+)|(/\\*\\*[^**/]+\\*\\*/)|(/\\*[^*/]+\\*/))", Pattern.MULTILINE);
        Matcher m = p.matcher(strbul.toString());
        while (m.find()) {
            System.out.println(m.group());
        }
        in.close();
    }
}
