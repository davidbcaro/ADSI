using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class WorkingDay
    {
        [Key]
        [Column(Order = 2)]
        public int IDinitials { get; set; }
        [Display(Name = "Initials")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string initials { get; set; }
        [Display(Name = "Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string name { get; set; }
        [Display(Name = "Description")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string description { get; set; }
        [Display(Name = "Photo")]
        // cambiar campo a tipo picture despues
        public int photo { get; set; }



 

        



    }
}