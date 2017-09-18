using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Visitor
{
    class Product:IVisitable
    {
        public string Name { get; set; }
        public double Price { get; set; }

        public Product(string name, double price)
        {
            Name = name;
            Price = price;
        }


        public void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
