using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Observer
{
    class OnlineStore:IOnlineStore
    {
        public List<Product> _inventoryProducts = new List<Product>();
        public List<ISubscriber> _subscribers = new List<ISubscriber>();

        public bool Subscribe(ISubscriber subscriber)
        {
            if (_subscribers.Contains(subscriber))
                return false;
            _subscribers.Add(subscriber);
            return true;
        }

        public bool UnSubscribe(ISubscriber iSubscriber)
        {
            if (!_subscribers.Contains(iSubscriber))
                return false;
            _subscribers.Add(iSubscriber);
            return true;
        }

        public void Notify(List<Product> products)
        {
            Console.WriteLine("\n----Notifying costumers-----");
            foreach (ISubscriber subscriber in _subscribers)
                subscriber.Update(products);
            Console.WriteLine();
        }

        public void AddProduct(List<Product> products)
        {
            List<Product> newProducts = new List<Product>();

            if (_inventoryProducts.Count == 0)
            {
                _inventoryProducts.AddRange(products);
                newProducts.AddRange(products);
            }
            else
            {
                foreach (Product p in products)
                {
                    int j = _inventoryProducts.IndexOf(p);
                    if (j != -1)
                        p.Count += _inventoryProducts[j].Count;
                    else
                    {
                        _inventoryProducts.Add(p);
                        newProducts.Add(p);
                    }
                }
            }
            if (newProducts.Count != 0)
                Notify(newProducts);

        }

        public void Inventory()
        {
            double sum = 0;
            foreach (Product p in _inventoryProducts)
                sum += p.Price*p.Count;
            Console.WriteLine("The sum of the products is " + sum);

        }
    }
}
