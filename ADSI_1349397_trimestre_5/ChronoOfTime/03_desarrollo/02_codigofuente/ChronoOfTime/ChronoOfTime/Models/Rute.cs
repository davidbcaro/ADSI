using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Rute
    {
        [Key]
        public int IDRute { get; set; }

        [StringLength(50)]
        [Display(Name = "Rute")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string name { get; set; }

        [Display(Name ="State")]
        public bool state { get; set; }
    }
}