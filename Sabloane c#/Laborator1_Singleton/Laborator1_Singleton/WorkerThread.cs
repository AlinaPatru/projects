using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator1_Singleton
{
    class WorkerThread
    {
        public static void PostRequest()
        {
            LoadBalancer.GetInstance().AssignServer();
        }
    }
}
