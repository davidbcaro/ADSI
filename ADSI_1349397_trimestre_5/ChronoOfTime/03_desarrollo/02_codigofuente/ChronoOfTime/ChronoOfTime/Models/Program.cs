using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Program
    {
        [Key]
        [Column(Order = 5)]
        public int IDProgram { get; set; }

        [StringLength(30)]
        [Display(Name = "Code Program")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string codeProgram { get; set; }

        [StringLength(30)]
        [Display(Name = "Name Program")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string nameProgram { get; set; }

        [StringLength(10)]
        [Display(Name = "Edition Program")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string edition { get; set; }

        [StringLength(10)]
        [Display(Name = "Initial Program")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string initial { get; set; }

        [Display(Name = "State")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public bool state { get; set; }


        

        

        

       

    }
}