using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Activity
    {
       [Key]
       public int id_Actividad { get; set; }

        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(50, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Name { get; set; }

        public int id_Phase{ get; set; }
        public virtual Phase phase { get; set; }

        

    }
}