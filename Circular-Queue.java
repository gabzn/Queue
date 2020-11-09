import java.util.NoSuchElementException;

public class QueueUsingArray
{
    private int[] queue;
    private int size;
    private int front;
    private int end;

    public QueueUsingArray(int capacity)
    {
        queue = new int[capacity];
        front = end = -1;
        size = 0;
    }

    public void enqueue(int data)
    {
        if(isEmpty())
        {
            front = end = 0;
            queue[end] = data;
            size++;
            return;
        }
//        if(isFull())
//        {
//            end = (end+1)%queue.length;
//            queue[end] = data;
//            return;
//        }
//        end++;
//        queue[end] = data;
//        size++;
        end = (end+1) % queue.length;
        queue[end] = data;
        if(isFull()) return;
        size++;
    }

    public void dequeue()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("Empty queue");
        }

        if(front == end)
        {
            front = end = -1;
            size = 0;
            return;
        }
        front = (front+1) % queue.length;
        size--;
    }

    public int peek()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("Empty queue");
        }
        return queue[front];
    }

    public boolean isFull()
    {
        return (size == queue.length);
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public int getQueueSize()
    {
        return size;
    }

    public void display()
    {
        for(int i=0;i<queue.length;i++)
        {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public void getFrontEnd()
    {
        System.out.println("Front is " + queue[front]);
        System.out.println("End is " + queue[end]);
    }
}
