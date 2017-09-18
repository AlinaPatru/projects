using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator1_Singleton
{
    class LoadBalancer
    {
        private static LoadBalancer instance = null;
        public List<Server> serversList;
        private static readonly object lockM = new Object();
        private bool flagType = false;
        private static Random random = new Random();

        public LoadBalancer()
        {
            string ip = "127.168.7.";
            serversList = new List<Server>();
            for (int i = 0; i < 10; i++)
            {
                serversList.Add(new Server { Name = "ServerNumber" + (i + 1).ToString(), IpAdress = ip + i.ToString() });
            }
        }

        public static LoadBalancer GetInstance()
        {
            if (instance == null)
            {
                lock (lockM)
                {
                    instance = new LoadBalancer();
                }
            }
            return instance;
        }

        public void AssignServer()
        {
            Server serverAssigned = serversList.ElementAt(0);
            int minimumAmountOfRequests = serversList.ElementAt(0).NumOfRequests;

            if (flagType)
            {
                foreach (Server server in serversList)
                {
                    if (server.NumOfRequests < minimumAmountOfRequests)
                    {
                        minimumAmountOfRequests = server.NumOfRequests;
                        serverAssigned = server;
                    }
                }
            }
            else
            {
                serverAssigned = serversList.ElementAt(random.Next(0, 10));
            }

            serverAssigned.ProcessRequest();

        }

    }
}
