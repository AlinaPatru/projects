using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Visitor
{
    class Program
    {
        static void Main(string[] args)
        {
            SupermarketReport supermarketReport = new SupermarketReport();
            Order order1 = new Order("order1");
            order1.Add(new Product("Branza", 25));
            order1.Add(new Product("Smantana", 15));

            Customer c1 = new Customer("Alina");
            c1.Add(order1);
            c1.Accept(supermarketReport);
            Order order2 = new Order("order2");
            order2.Add(new Product("Branza", 35));
            order2.Add(new Product("Smantana", 25));

            Customer c2 = new Customer("Sorin");
            c2.Add(order2);
            c2.Accept(supermarketReport);

            supermarketReport.DisplayResults();
            Console.Read();



        }
    }
}
