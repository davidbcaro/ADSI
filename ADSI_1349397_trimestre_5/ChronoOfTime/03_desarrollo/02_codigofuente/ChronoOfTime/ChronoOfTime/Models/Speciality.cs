using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Speciality
    {
        [Key]
        [Column(Order = 13)]
        public int IDSpeciality { get; set; }
        public string name { get; set; }
        public bool state { get; set; }
        public virtual ICollection<Instructor> Instructors { get; set; }
    }
}