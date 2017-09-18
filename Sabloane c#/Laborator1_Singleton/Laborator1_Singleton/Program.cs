using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Laborator1_Singleton
{
    class Program
    {
        static void Main(string[] args)
        {

            List<Thread> threads = new List<Thread>();

            for (int i = 0; i < 5;i++ )
            {
                threads.Add(new Thread(() => ThreadWork()));
            }

            foreach (Thread thread in threads)
            {
                thread.Start();
                thread.Join();
            }
           

            Console.WriteLine("\n------ Printing report ------ \n");
            foreach (Server server in LoadBalancer.GetInstance().serversList)
            {
                server.PrintReport();
            }

            Console.Read();
        }

        public static void ThreadWork()
        {
            for (int i = 0; i < 5; i++)
            {
                WorkerThread.PostRequest();
            }
        }
    }
}
