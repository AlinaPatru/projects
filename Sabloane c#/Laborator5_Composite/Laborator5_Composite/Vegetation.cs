using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Composite
{
    abstract class Vegetation
    {
        protected string name;
        protected string parentName;

        public Vegetation(string name, string parentName)
        {
            this.name = name;
            this.parentName = parentName;
        }

        public abstract void Add(Vegetation vegetation);
        public abstract void Remove(Vegetation vegetation);
        public abstract void Display(int depth);
    }
}
