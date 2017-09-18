using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    public class CarDecorator : ICar
    {
        public ICar Car { get; set; }
        public ECarType Type { get; set; }

        public CarDecorator(ICar car)
        {
            Car = car;
        }

        public void SetAccessory(EAccessoriesType type, string name, int price)
        {
            Car.SetAccessory(type, name, price);
        }

        public virtual void Assemble()
        {
            Car.Assemble();
        }

        public void Display()
        {
            Car.Display();
        }
    }
}
