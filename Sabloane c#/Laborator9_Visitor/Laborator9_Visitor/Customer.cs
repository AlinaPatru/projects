using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Visitor
{
    class Customer:IVisitable
    {
        public string Name { get; set; }
        public List<Order> _orders = new List<Order>();
        
        public Customer(string name)
        {
            Name = name;
        }

        public void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
            foreach (Order o in _orders)
                o.Accept(visitor);
        }
      
        public void Add(Order order)
        {
            _orders.Add(order);
        }
    }
}
