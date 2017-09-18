using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Visitor
{
    class Order:IVisitable
    {
        public string Name { get; set; }
        public List<Product> _products = new List<Product>();

        public Order(string name)
        {
            Name = name;
        }

        public void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
            foreach (Product p in _products)
                p.Accept(visitor);
        }

        public void Add(Product product)
        {
            _products.Add(product);
        }
    }
}
