using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Headquarters
    {
        [Key]
        [Column(Order = 22)]
        public int IDHeadquarters { get; set; }
        [StringLength(50)]
        [Display(Name = "Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string nameHead { get; set; }
        [StringLength(30)]
        [Display(Name = "Address")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string direction { get; set; }
        public bool state { get; set; }

        //environment
        [Display(Name = "Environment")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public int IDEnvironment { get; set; }
        [ForeignKey("IDEnvironment")]
        public virtual Environmenty Environment { get; set; }

        


    }
}