using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Observer
{
    class Program
    {
        static void Main(string[] args)
        {
            OnlineStore store = new OnlineStore();
            List<Product> products=new List<Product>();

            for (int i = 0; i < 5; i++)
                products.Add(new Product("Product" + i, "product's description", 50 + i,1));

            Subscriber subscriber1 = new Subscriber("Alina");
            Subscriber subscriber2 = new Subscriber("Victoras");

            store.Subscribe(subscriber1);
            store.Subscribe(subscriber2);

            store.AddProduct(products);

            store.Inventory();

            for (int i = 0; i < 5; i++)
                products.Add(new Product("Product" + (i+5), "product's description", 50 +( i+5), 2));

            store.AddProduct(products);

            store.Inventory();

            Console.Read();
        }
    }
}
