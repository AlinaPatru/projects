using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator2_Factory
{
    class Dealer
    {
        private List<Car> testDriveCars { get; set; }
        private List<Car> availableCars { get; set; }
        Random random = new Random();

        public Dealer(List<Car> avCars, List<Car> testCars)
        {
            testDriveCars =testCars;
            availableCars = avCars;
        }

        public void TestCar(int id, int km)
        {
            foreach (Car car in testDriveCars)
            {
                if (car.Id == id)
                {
                    car.TestDriveKm = km;
                }
            }
        }

        public void GetCarTestKm(int id)
        {
            foreach (Car car in testDriveCars)
            {
                if (car.Id == id)
                {
                    Console.WriteLine("Car " + id + " has " + car.TestDriveKm + " test drive km.");
                }
            }
        }

        public void DriveTest(int id)
        {
            foreach (Car car in availableCars)
            {
                if (id == car.Id)
                {
                    int rand = random.Next(1, 100);
                    car.Test(rand);
                    testDriveCars.Add(car);
                    Console.WriteLine("The km the car made are = " + rand);

                }
            }
        }

        public void SellCar(int id)
        {
            foreach (Car car in availableCars)
            {
                if (id == car.Id)
                {
                    availableCars.Remove(car);
                    Console.WriteLine("The car with the id " + car.Id + " was sold.");
                }
                else
                    Console.WriteLine("The car is not available");
            }
        }

        public void DisplayAvailableCarsInfo()
        {
            Console.WriteLine("-------Available cars------\n");
            foreach (Car car in availableCars)
            {
                Console.WriteLine("Type= "+car.GetCarType()+"\nId= "+ car.Id+"\nBrand= "+car.Brand+"\nEngine= "+ car.Engine.ToString());
                Console.WriteLine("\n");
            }
        }

        public void DisplayTestCarsInfo()
        {
            Console.WriteLine("-------Test drive cars------\n");
            foreach (Car car in testDriveCars)
            {
                Console.WriteLine("Type= " + car.GetCarType() + "\nId= " + car.Id + "\nBrand= " + car.Brand + "\nEngine= " + car.Engine.ToString());
                Console.WriteLine("\n");
            }
        }
   
    }
}
