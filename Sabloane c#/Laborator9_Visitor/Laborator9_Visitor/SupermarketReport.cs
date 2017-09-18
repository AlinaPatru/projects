using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Visitor
{
    class SupermarketReport:IVisitor
    {
        private int iProductNo=0;
        private int iOrderNo=0;
        private int iCustomerNo=0;
        private double dTotalPrice;

        public void DisplayResults()
        {
            Console.WriteLine("Number of Customers:" + iCustomerNo);
            Console.WriteLine("Number of orders:" + iOrderNo);
            Console.WriteLine("Number of products:" + iProductNo);
            Console.WriteLine("Total price: " + dTotalPrice);
        }

        public void Visit(Product product)
        {
            iProductNo++;
            dTotalPrice += product.Price;
        }

        public void Visit(Order order)
        {
            iOrderNo++;
        }

        public void Visit(Customer customer)
        {
            iCustomerNo++;
        }
    }
}
