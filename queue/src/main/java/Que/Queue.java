/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Que;

/**
 *
 * @author ACER
 */
public class Queue {
    
    int data[];
    int head = 0;
    int tail = -1;
    
    public Queue(int size)
            
    {
        data = new int[size];
    }
    
    public boolean isEmpty()
    {
        if(tail==-1)
        {
            return true;
        }else {
            
            return false;
        }
    }
    
    public boolean isFull()
    {
        if(tail==data.length-1)
        {
            return true;
        }else{
            return false;
        }
    }
    
    public void Enqueue (int dataBaru)
    {
        if(isEmpty())
        {
            tail = head;
            
            data[tail] = dataBaru;
        }else if(!isFull()){
            tail++;
            data[tail] = dataBaru;
        }else if(isFull())
        {
            System.out.println("Antrian Penug");
        }
        
        
    }
    
    public int Dequeue()
        {
         int temp = data[head];
         
         for(int i=head; i<=tail-1; i++)
         {
             data[i] = data[i+1];
         }
         tail--;
         return temp;
        }
    
    public void tampilkan()
    {
        if(!isEmpty())
        {
            int index = head;
            
            while(index <= tail)
            {
                System.out.println("|"+data[index]+"|");
                
                index++;
            }
            System.out.println();
            
        }else {
                System.out.println("Kosong");
              }
        }
    
    
    }
    
