using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator2_Factory
{
    abstract class Car
    {
        public int Id { get; set; }
        public EngineType Engine { get; set; }
        public BrandType Brand { get; set; }
        public int TestDriveKm { get; set; }

        public Car(int id, BrandType brandType, EngineType engine)
        {
            this.Id = id;
            this.Brand = brandType;
            this.Engine = engine;
        }

        abstract public CarType GetCarType();

        public void Test(int km)
        {
            TestDriveKm += km;
        }

        public override string ToString()
        {
            return string.Format("Type = {0} Id = {1} Brand = {2} Engine = {3} TestDriveKm = {4}", this.GetCarType(),
                Id, Brand.ToString(), Engine.ToString(), TestDriveKm);
        }
    }
}
