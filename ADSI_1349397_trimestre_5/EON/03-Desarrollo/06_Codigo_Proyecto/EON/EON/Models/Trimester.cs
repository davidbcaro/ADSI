using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Trimester
    {

        [Key]
        [Display(Name = "idTrimester")]
        public int id_Trimester { get; set; }

        [Display(Name = "quarter Name")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(45, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string quarter_Name { get; set; }

        public int id_Speciality { get; set; }
        public virtual Speciality Speciality { get; set; }

        public int id_working_Day { get; set; }
        public virtual workingDay workingDay { get; set; }

        public virtual ICollection<Schedule> schedule { get; set; }
    }
}