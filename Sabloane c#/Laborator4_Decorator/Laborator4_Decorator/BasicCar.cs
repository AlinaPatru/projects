using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    public class BasicCar : ICar
    {
        public ECarType Type { get; set; }
        public string Color { get; set; }
        public int Price { get; set; }
        public string Engine { get; set; }

        public List<string> AccesTypeAccessories { get; set; }
        public List<string> AmbienceTypeAccessories { get; set; }
        public List<string> LaureateTypeAccessories { get; set; }

        public BasicCar()
        {
            AccesTypeAccessories = new List<string>();
            AmbienceTypeAccessories = new List<string>();
            LaureateTypeAccessories = new List<string>();
            Type = ECarType.Basic;

        }

        public void Assemble()
        {
            Color = "Red";
            Engine = "Gas";
            Price = 7800;
        }

        public void Display()
        {
            Console.WriteLine("---------Car info---------"+"\n");
            Console.WriteLine("Type is " + Type);
            Console.WriteLine("Color is "+ Color);
            Console.WriteLine("Engine is "+ Engine);
            Console.WriteLine("Price is "+ Price);
            
            Console.WriteLine("\n");
            Console.WriteLine("Acces Accessories");
            foreach (var item in AccesTypeAccessories)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("\n");
            Console.WriteLine("Ambience Accessories");
            foreach (var item in AmbienceTypeAccessories)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("\n");
            Console.WriteLine("Laureate Accessories");
            foreach (var item in LaureateTypeAccessories)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("\n" + "\n");
        }

        public void SetAccessory(EAccessoriesType type, string name, int price)
        {
            List<string> result = null;
            switch (type)
            {
                case EAccessoriesType.AccesType:
                    result = AccesTypeAccessories;
                    break;
                case EAccessoriesType.AmbianceType:
                    result = AmbienceTypeAccessories;
                    break;
                case EAccessoriesType.LaureateType:
                    result = LaureateTypeAccessories;
                    break;
                default:
                    break;
            }
            result.Add(name);
            Price += price;
        }
    }
}
