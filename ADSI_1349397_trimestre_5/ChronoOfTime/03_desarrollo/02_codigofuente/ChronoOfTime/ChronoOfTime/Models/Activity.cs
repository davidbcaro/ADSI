using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Activity
    {
        [Key]
        [Column(Order = 17)]
        public int IDActivity { get; set; }

        [StringLength(150)]
        [Display(Name = "Name")]
        [Required(ErrorMessage = "El campo Name es obligatorio")]
        public string name { get; set; }


        //foreign 2
        
        public int mame_phase { get; set; }
        [ForeignKey("mame_phase ")]
        public Phase Phase { get; set; }




  




    }
}