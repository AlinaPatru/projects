using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator9_Visitor
{
    interface IVisitable
    {
        void Accept(IVisitor visitor);
    }
}
