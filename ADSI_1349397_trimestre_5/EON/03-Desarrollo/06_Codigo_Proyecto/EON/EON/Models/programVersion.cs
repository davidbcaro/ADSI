using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class programVersion
    {
        [Key]
        [Display(Name = "idProgramVersion")]
        public int id_programVersion { get; set; }

        [Display(Name = "Version")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Version { get; set; }

        [Display(Name = "Status")]
        public bool Status { get; set; }

        public virtual ICollection<Program> Programs { get; set; }
    }
}