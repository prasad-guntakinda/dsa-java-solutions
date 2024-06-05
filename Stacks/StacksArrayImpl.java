package dsa.solutions.Stacks;

import java.util.Arrays;

public class StacksArrayImpl {
    private int[] arr;
    private int curr_index;
    private int size = 10;

    StacksArrayImpl(int size){
        this.size = size;
        this.arr = new int[this.size];
        this.curr_index = -1;
    }

    public void push(int num){
        if(curr_index == size-1){
            resize(this.size*2);
        }
        arr[++curr_index] = num;
    }

   /* public int peek(){
        if(arr.length == 0){

        }
    }*/

    private void resize(int new_capacity) {
        this.arr = Arrays.copyOf(arr, new_capacity);
        this.size = new_capacity;

    }


}
