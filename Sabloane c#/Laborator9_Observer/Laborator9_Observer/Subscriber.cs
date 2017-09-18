using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Observer
{
    class Subscriber:ISubscriber
    {
        public string Name
        {
            get;
            set;
        }

        public Subscriber(string name)
        {
            Name = name;
        }

        public void Update(List<Product> products)
        {
            Console.WriteLine(Name);
            foreach (Product p in products)
                Console.WriteLine(p);
        }
    }
}
