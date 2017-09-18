using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    public interface ICar
    {
        ECarType Type { get; set; }


        void SetAccessory(EAccessoriesType type, string name, int price);
        void Assemble();
        void Display();
    }
}
