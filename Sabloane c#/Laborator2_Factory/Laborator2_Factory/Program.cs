using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator2_Factory
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Car> carsList = new List<Car>();
            List<Car> testCarsList = new List<Car>();
            List<Car> comCarsList = new List<Car>();
            CarFactory automobileFactory = new AutomobileFactory();
            CarFactory truckFactory = new TruckFactory();

            carsList.Add(automobileFactory.GetCar(BrandType.MercedesBenz, EngineType.Diesel));
            comCarsList.Add(automobileFactory.GetCar(BrandType.MercedesBenz, EngineType.Diesel));

            Dealer dealer = new Dealer(carsList, testCarsList);
            dealer.DisplayAvailableCarsInfo();

            dealer.DriveTest(1);
            dealer.GetCarTestKm(1);
            dealer.DisplayTestCarsInfo();

            Console.Read();

        }
    }
}
