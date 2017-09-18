using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Observer
{
    interface IOnlineStore
    {
        bool Subscribe(ISubscriber iSubscriber);
        bool UnSubscribe(ISubscriber iSubscriber);
        void Notify(List<Product> products);
        void AddProduct(List<Product> products);
        void Inventory();

    }
}
