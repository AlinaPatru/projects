using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Laborator1_Singleton
{
    class Server
    {
        public string Name { get; set; }
        public string IpAdress { get; set; }
        public int NumOfRequests { get; set; }
        public int MinimumProcessingTime { get; set; }
        public int MaximumProcessingTime { get; set; }
        public int TotalProcessingTime { get; set; }
        public int AverageProcessingTime { get; set; }
        public int ProcessingTime { get; set; }

        private static Random random = new Random();

        public void ProcessRequest()
        {
            ++NumOfRequests;
            ProcessingTime = random.Next(500, 1000);
            CalculateTimes(ProcessingTime);
            Thread th = new Thread(new ThreadStart(WorkThreadFunction));
            th.Start();
            Thread.Sleep(ProcessingTime);
        }

        public void WorkThreadFunction()
        {
            Console.WriteLine(Name + "\nThe processing time is " + ProcessingTime + " ms.\nHas  " + NumOfRequests + " requests.\n");
        }

        public void CalculateTimes(int newTime)
        {
            if (NumOfRequests == 1)
            {
                MinimumProcessingTime = 1001;
            }
            if (newTime < MinimumProcessingTime)
                MinimumProcessingTime = newTime;
            if (newTime > MaximumProcessingTime)
                MaximumProcessingTime = newTime;
            TotalProcessingTime += newTime;
            AverageProcessingTime = TotalProcessingTime / NumOfRequests;

        }

        public void PrintReport()
        {
            Console.WriteLine(Name + " with the IP adress " + IpAdress + " had " + NumOfRequests + " requests");
            Console.WriteLine("The minimum processing time was " + MinimumProcessingTime);
            Console.WriteLine("The maximum processing time was " + MaximumProcessingTime);
            Console.WriteLine("The average processing time was " + AverageProcessingTime);
            Console.WriteLine("The total processing time was " + TotalProcessingTime + "\n");
        }
    }
}
