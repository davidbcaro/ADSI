using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Environmenty
    {
        [Key]
        [Column(Order = 21)]
        public int IDEnvironment { get; set; }
        [Display(Name = "Number Environment")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string numEnvironment { get; set; }

        [Display(Name = "State")]

        public bool state { get; set; }

        [Display(Name = "Description")]
        [StringLength(200)]
        public string description { get; set; }

        

        

    }
}