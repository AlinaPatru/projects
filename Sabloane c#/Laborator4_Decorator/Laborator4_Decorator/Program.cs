using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    class Program
    {
        static void Main(string[] args)
        {
            CarDecorator acces = new AccesDecorator(new BasicCar());
            acces.Assemble();
            acces.Display();

            CarDecorator ambiance = new AmbianceDecorator(new BasicCar());
            ambiance.Assemble();
            ambiance.Display();

            CarDecorator laureate = new LaureateDecorator(new BasicCar());
            laureate.Assemble();
            laureate.Display();

            Console.Read();
        }
    }
}
