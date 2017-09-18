using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator3_Builder_Prototype
{
    class Program
    {
        static void Main(string[] args)
        {
            var cars = new List<Car>();
            ICarBuilder builder = new CarBuilder();
            CarBuildDirector director = new CarBuildDirector(builder);
            for (int i = 0; i < 5; i++)
            {
                var model = (Model)i;
                director.Construct(model);
                var car = director.GetResult();
                cars.Add(car);
                Console.WriteLine(car);

            }
            var clone = cars.ElementAt(3).Clone();

            if (clone.IsClone)
            {
                Console.WriteLine("This car is a clone");
                Console.WriteLine(clone);
            }

            Console.Read();
        }
    }
}
