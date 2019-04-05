using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Modality
    {
        [Key]
        [Column(Order = 23)]
        public int IDModality { get; set; }
        [Display(Name = "nameModality")]
        public string nameModality { get; set; }
        [Display(Name = "state")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public Boolean state { get; set; }


        
    }
}